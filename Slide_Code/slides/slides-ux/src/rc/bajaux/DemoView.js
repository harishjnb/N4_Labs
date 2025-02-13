/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule/slides/rc/bajaux/DemoView
 */
/* eslint-env browser */
define([
  'baja!',
  'bajaux/Widget',
  'bajaux/mixin/subscriberMixIn',
  'bajaux/util/SaveCommand',
  'Promise',
  'baja!slides:Demo'
], function (
  baja,
  Widget,
  subscriberMixIn,
  SaveCommand,
  Promise
) {
  'use strict';

  /**
   * A custom widget that can display and edit values on a slides:Demo.
   *
   * @class
   * @alias module:nmodule/slides/rc/bajaux/DemoView
   * @extends module:bajaux/Widget
   */
  return class DemoView extends Widget {
    constructor(params) {
      super({
        params,
        defaults: {
          properties: {
            rootCssClass: 'demo-view'
          }
        }
      }
    );

      subscriberMixIn(this);
      this.getSubscriber().attach('changed', () => {
        const newValue = this.value();
        this.$updateDom(newValue);
      });

      this.getCommandGroup().add(new SaveCommand());
    }

    /**
     * @param {jQuery} dom A jQuery wrapper around the DOM node into which this widget is being initialized
     */
    doInitialize(dom) {
      dom.html(`
        <div class="wrapper">
          <div class="int-property-editor">
            <label for="int-property-input">Int Property</label>
            <input id="int-property-input" type="number" >
          </div>
          <div class="string-property-editor">
            <label for="string-property-input">String Property</label>
            <input id="string-property-input" type="text" >
          </div>
          <div class="boolean-property-editor">
            <label for="boolean-property-input">Boolean Property</label>
            <input id="boolean-property-input" type="checkbox" >
          </div>
        </div>
      `);

      dom.on('change', 'input', () => {
        this.setModified(true);
      });
    }

    /**
     * @param {*} demo The proxy component being loaded into this widget
     */
    doLoad(demo) {
      this.$updateDom(demo);
    }

    /**
     * @returns {*} An instance of slides:Demo constructed from the current values in the DOM
     */
    doRead() {
      const readDemo = baja.$('slides:Demo');

      readDemo.setIntProperty(Number(this.jq().find('#int-property-input').val()));
      readDemo.setStringProperty(this.jq().find('#string-property-input').val());
      readDemo.setBooleanProperty(this.jq().find('#boolean-property-input').prop('checked'));

      return readDemo;
    }

    /**
     * @param {*} readValue The instance of slides:Demo returned from doRead()
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
     * @param {*} demo An instance of slides:Demo to use to update the DOM
     */
    $updateDom(demo) {
      this.jq().find('#int-property-input').val(demo.getIntProperty());
      this.jq().find('#string-property-input').val(demo.getStringProperty());
      this.jq().find('#boolean-property-input').prop('checked', demo.getBooleanProperty());
    }
  };
});
