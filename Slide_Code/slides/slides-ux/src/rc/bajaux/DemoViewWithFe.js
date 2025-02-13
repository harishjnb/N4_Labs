/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule/slides/rc/bajaux/DemoViewWithFe
 */
/* eslint-env browser */
define([
  'baja!',
  'bajaux/Widget',
  'nmodule/webEditors/rc/fe/fe',
  'bajaux/mixin/subscriberMixIn',
  'bajaux/events',
  'bajaux/util/SaveCommand',
  'baja!slides:Demo'
], function (
  baja,
  Widget,
  fe,
  subscriberMixIn,
  events,
  SaveCommand
) {
  'use strict';

  /**
   * A widget that uses child widgets built by Niagara to display and edit values on a slides:Demo
   *
   * @class
   * @alias module:nmodule/slides/rc/bajaux/DemoViewWithFe
   * @extends module:bajaux/Widget
   */
  return class DemoViewWithFe extends Widget {
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
        this.$updateChildWidgets(newValue);
      });

      this.getCommandGroup().add(new SaveCommand());
    }

    /**
     * @param {jQuery} dom A jQuery wrapper around the DOM node into which this widget is being initialized
     * @returns {Promise} A Promise that resolves once fe has initialized and loaded all child widgets
     */
    doInitialize(dom) {
      dom.html(`
        <div class="wrapper">
          <label>Int Property</label>
          <div class="int-property-editor"></div>
          <label>String Property</label>
          <div class="string-property-editor"></div>
          <label>Boolean Property</label>
          <div class="boolean-property-editor"></div>
        </div>
      `);

      dom.on(events.MODIFY_EVENT, (event, editor) => {
        if (this.getChildWidgets().includes(editor)) {
          this.setModified(true);
        }
      });

      // There are many ways to call fe.buildFor. The way I'm doing it specifies a value, form factor,
      // and dom node. fe will:
      //   * look up the type of the value
      //   * instantiate a bajaux editor for that type with the given form factor
      //   * initialize the bajaux editor into the specified dom node
      //   * load the value into the dom node
      //
      // I could call this in doLoad and pass in the actual Property values I want to load in. The
      // problem is that doLoad can be called multiple times as different values are loaded into this
      // Widget. So instead I'm calling fe.buildFor in doInitialize and making a slides:Demo so I can
      // pass the default Property values in for fe to determine the correct types.
      return Promise.all([
        fe.buildFor({
          value: baja.$('slides:Demo').getIntProperty(),
          formFactor: 'mini',
          dom: dom.find('.int-property-editor')
        }),
        fe.buildFor({
          value: baja.$('slides:Demo').getStringProperty(),
          formFactor: 'mini',
          dom: dom.find('.string-property-editor')
        }),
        fe.buildFor({
          value: baja.$('slides:Demo').getBooleanProperty(),
          formFactor: 'mini',
          dom: dom.find('.boolean-property-editor')
        })
      ]);
    }

    /**
     * @param {*} demo The proxy component being loaded into this widget
     * @returns {Promise} A Promise that resolved once all child widgets have been loaded
     */
    doLoad(demo) {
      return this.$updateChildWidgets(demo);
    }

    /**
     * @returns {Promise} A Promise that resolves to an instance of slides:Demo constructed from the read values from
     * the child widgets
     */
    doRead() {
      const demo = baja.$('slides:Demo');

      return Promise.all([
        Widget.in(this.jq().find('.int-property-editor')).read(),
        Widget.in(this.jq().find('.string-property-editor')).read(),
        Widget.in(this.jq().find('.boolean-property-editor')).read()
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
      return this.getChildWidgets().destroyAll();
    }

    /**
     * @param {*} demo An instance of slides:Demo to load into the child widgets
     * @returns {Promise} A Promise that resolves when all child widgets have loaded the new value
     */
    $updateChildWidgets(demo) {
      return Promise.all([
        Widget.in(this.jq().find('.int-property-editor')).load(demo.getIntProperty()),
        Widget.in(this.jq().find('.string-property-editor')).load(demo.getStringProperty()),
        Widget.in(this.jq().find('.boolean-property-editor')).load(demo.getBooleanProperty())
      ]);
    }
  };
});
