/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule/slides/rc/bajaux/editors/BooleanEditor
 */
/* eslint-env browser */
define([
  'bajaux/Widget'
], function (
  Widget
) {
  'use strict';

  
  /**
   * @class
   * @alias module:nmodule/slides/rc/bajaux/editors/BooleanEditor
   * @extends module:bajaux/Widget
   */
  return class BooleanEditor extends Widget {
    constructor(params) {
      super({
        params,
        defaults: {
          properties: {
            label: 'Boolean'
          }
        }
      });
    }

    /**
     * @param {jQuery} dom A jQuery wrapper around the DOM node into which this widget is being initialized
     */
    doInitialize(dom) {
      const id = this.$createUniqueId();
      dom.html(`
        <label for="${ id }">${ this.properties().getValue('label') }</label>
        <input id="${ id }" type="checkbox" >
      `);

      dom.on('change', 'input', () => { this.setModified(true); });
    }

    /**
     * @param {boolean} boolean The boolean being loaded into this widget
     */
    doLoad(boolean) {
      this.jq().find('input').prop('checked', boolean);
    }

    /**
     * @returns {boolean} A boolean read from the DOM
     */
    doRead() {
      return this.jq().find('input').prop('checked');
    }

    /**
     * @returns {string} An id that uniquely identifies this element even if multiple BooleanEditors are used on one page
     */
    $createUniqueId() {
      return `boolean-editor-${ crypto.randomUUID() }`;
    }
  };
});
