/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule/slides/rc/spandrel/DemoView
 */
/** @jsx spandrel.jsx */
/* eslint-env browser */
define([
  'baja!',
  'bajaux/spandrel',
  'bajaux/mixin/subscriberMixIn',
  'bajaux/util/SaveCommand',
  'baja!slides:Demo'
], function (
  baja,
  spandrel,
  subscriberMixIn,
  SaveCommand
) {
  'use strict';

  /**
   * A custom widget that can display and edit values on a slides:Demo.
   *
   * @class
   * @alias module:nmodule/slides/rc/spandrel/DemoView
   * @extends module:bajaux/spandrel
   */
  return class DemoView extends spandrel((demo, { self }) => {
    return (<div className="wrapper">
      <div className="int-property-editor">
        <label for="int-property-input">Int Property</label>
        <input id="int-property-input" type="number"
               value={demo.getIntProperty()}
               onChange={() => self.setModified(true)}
        />
      </div>
      <div className="string-property-editor">
        <label for="string-property-input">String Property</label>
        <input id="string-property-input" type="text"
               value={demo.getStringProperty()}
               onChange={() => self.setModified(true)}
        />
      </div>
      <div className="boolean-property-editor">
        <label for="boolean-property-input">Boolean Property</label>
        <input id="boolean-property-input" type="checkbox"
               checked={demo.getBooleanProperty()}
               onChange={() => self.setModified(true)}
        />
      </div>
    </div>);
  }) {
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
      this.getSubscriber().attach('changed', () => this.render(this.value()));
      this.getCommandGroup().add(new SaveCommand());
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
  };
});
