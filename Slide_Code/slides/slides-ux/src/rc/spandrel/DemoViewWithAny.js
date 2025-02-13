/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule/slides/rc/spandrel/DemoViewWithAny
 */
/** @jsx spandrel.jsx */
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
   * A widget that uses child widgets built by Niagara to display and edit values on a slides:Demo
   *
   * @class
   * @alias module:nmodule/slides/rc/spandrel/DemoViewWithAny
   * @extends module:bajaux/Widget
   */
  return class DemoViewWithAny extends spandrel((demo) => {
    return (
      <div className="wrapper" spandrelKey='wrapper'>
        <div className="int-property-editor" spandrelKey='intPropertyEditor'>
          <any value={demo.getIntProperty()} spandrelKey='numberEditor' />
        </div>
        <div className="string-property-editor" spandrelKey='stringPropertyEditor'>
          <any value={demo.getStringProperty()} spandrelKey='stringEditor' />
        </div>
        <div className="boolean-property-editor" spandrelKey='booleanPropertyEditor'>
          <any value={demo.getBooleanProperty()} spandrelKey='booleanEditor'/>
        </div>
      </div>
    );
  }, { strategy: 'niagara' }) {
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
     * @returns {Promise} A Promise that resolves to an instance of slides:Demo constructed from the read values of
     * the child widgets
     */
    doRead() {
      const demo = baja.$('slides:Demo');

      return Promise.all([
        this.queryWidget('wrapper/intPropertyEditor/numberEditor').read(),
        this.queryWidget('wrapper/stringPropertyEditor/stringEditor').read(),
        this.queryWidget('wrapper/booleanPropertyEditor/booleanEditor').read()
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
  };
});
