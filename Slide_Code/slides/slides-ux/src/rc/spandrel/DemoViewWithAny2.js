/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule/slides/rc/spandrel/DemoViewWithAny2
 */
/** @jsx spandrel.jsx */
define([
  'baja!',
  'bajaux/spandrel',
  'bajaux/util/SaveCommand',
  'baja!slides:Demo'
], function (
  baja,
  spandrel,
  SaveCommand
) {
  'use strict';

  /**
   * A widget that uses child widgets built by Niagara to display and edit values on a slides:Demo
   *
   * @class
   * @alias module:nmodule/slides/rc/spandrel/DemoViewWithAny2
   * @extends module:bajaux/Widget
   */
  return class DemoViewWithAny2 extends spandrel((demo) => {
    return (
      <div className="wrapper" spandrelKey='wrapper'>
        <div className="int-property-editor" spandrelKey='intPropertyEditor'>
          <any complex={demo} slot='intProperty' formFactor='mini' spandrelKey='numberEditor' />
        </div>
        <div className="string-property-editor" spandrelKey='stringPropertyEditor'>
          <any complex={demo} slot='stringProperty' formFactor='mini' spandrelKey='stringEditor' />
        </div>
        <div className="boolean-property-editor" spandrelKey='booleanPropertyEditor'>
          <any complex={demo} slot='booleanProperty' formFactor='mini' spandrelKey='booleanEditor'/>
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

      this.getCommandGroup().add(new SaveCommand());
    }

    /**
     * @returns {Promise} A Promise that resolves once all child widgets have saved
     */
    doSave() {
      return Promise.all([
        this.queryWidget('wrapper/intPropertyEditor/numberEditor').save(),
        this.queryWidget('wrapper/stringPropertyEditor/stringEditor').save(),
        this.queryWidget('wrapper/booleanPropertyEditor/booleanEditor').save()
      ]);
    }
  };
});
