/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule/slides/rc/bajaux/DemoViewWithComposedWidgets
 */
/* eslint-env browser */
define([
  'baja!',
  'bajaux/Widget',
  'bajaux/mixin/subscriberMixIn',
  'bajaux/events',
  'bajaux/util/SaveCommand',
  'nmodule/slides/rc/bajaux/editors/NumberEditor',
  'nmodule/slides/rc/bajaux/editors/StringEditor',
  'nmodule/slides/rc/bajaux/editors/BooleanEditor',
  'Promise',
  'baja!slides:Demo'
], function (
  baja,
  Widget,
  subscriberMixIn,
  events,
  SaveCommand,
  NumberEditor,
  StringEditor,
  BooleanEditor,
  Promise
) {
  'use strict';
  

  /**
   * A custom widget that uses several child widgets to display and edit values on a slides:Demo
   *
   * @class
   * @alias module:nmodule/slides/rc/bajaux/DemoViewWithComposedWidgets
   * @extends module:bajaux/Widget
   */
  return class DemoViewWithComposedWidgets extends Widget {
    constructor(params) {
      super({
        params,
        defaults: {
          properties: {
            rootCssClass: 'demo-view'
          }
        }
      });

      subscriberMixIn(this);
      this.getSubscriber().attach('changed', () => {
        const newValue = this.value();
        this.$updateChildWidgets(newValue)
          .catch(err => console.error(err));
      });

      this.getCommandGroup().add(new SaveCommand());

      this.$numberEditor = new NumberEditor({ properties: { label: 'Int Property Editor' } });
      this.$stringEditor = new StringEditor({ properties: { label: 'String Property Editor' } });
      this.$booleanEditor = new BooleanEditor({ properties: { label: 'Boolean Property Editor' } });
    }

    /**
     * @param {jQuery} dom A jQuery wrapper around the DOM node into which this widget is being initialized
     * @returns {Promise} A Promise that resolves once all child widgets have been initialized
     */
    doInitialize(dom) {
      dom.html(`
        <div class="wrapper">
          <div class="int-property-editor"></div>
          <div class="string-property-editor"></div>
          <div class="boolean-property-editor"></div>
        </div>
      `);

      dom.on(events.MODIFY_EVENT, (event, editor) => {
        if (this.getChildWidgets().includes(editor)) {
          this.setModified(true);
        }
      });

      const intPropertyEditorElement = dom.find('.int-property-editor');
      const stringPropertyEditorElement = dom.find('.string-property-editor');
      const booleanPropertyEditorElement = dom.find('.boolean-property-editor');

      return Promise.all([
        this.$numberEditor.initialize(intPropertyEditorElement),
        this.$stringEditor.initialize(stringPropertyEditorElement),
        this.$booleanEditor.initialize(booleanPropertyEditorElement)
      ]);
    }

    /**
     * @param {*} demo The proxy component being loaded into this widget
     * @returns {Promise} A Promise that resolves once all child widgets have been loaded
     */
    doLoad(demo) {
      return this.$updateChildWidgets(demo);
    }

    /**
     * @returns {Promise} A Promise that resolves to an instance of slides:Demo constructed from the read values of
     * the child widgets
     */
    doRead() {
      const demo = baja.$('slides:Demo');

      return Promise.all([
        this.$numberEditor.read(),
        this.$stringEditor.read(),
        this.$booleanEditor.read()
      ])
        .then(([ number, string, boolean ]) => {
          demo.setIntProperty(number);
          demo.setStringProperty(string);
          demo.setBooleanProperty(boolean);
          return demo;
        });
    }

    /**
     * @param {*} readValue The instance of slides:Demo from doRead()
     * @returns {Promise} A Promise that resolves once the proxy component has set all of its properties
     */
    doSave(readValue) {
      const demo = this.value();
      return Promise.all([
        demo.setIntProperty(readValue.getIntProperty()),
        demo.setStringProperty(readValue.getStringProperty()),
        demo.setBooleanProperty(readValue.getBooleanProperty())
      ]);
    }

    /**
     * @returns {Promise} A Promise that resolves once all child widgets have been destroyed
     */
    doDestroy() {
      this.getChildWidgets().destroyAll();
    }

    /**
     * @param {*} demo An instance of slides:Demo to load into the child widgets
     * @returns {Promise} A Promise that resolves when all child widgets have loaded the new value
     */
    $updateChildWidgets(demo) {
      return Promise.all([
        this.$numberEditor.load(demo.getIntProperty()),
        this.$stringEditor.load(demo.getStringProperty()),
        this.$booleanEditor.load(demo.getBooleanProperty())
      ]);
    }
  };
});
