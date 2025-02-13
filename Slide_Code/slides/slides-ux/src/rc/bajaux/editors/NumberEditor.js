/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule/slides/rc/bajaux/editors/NumberEditor
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
   * @alias module:nmodule/slides/rc/bajaux/editors/NumberEditor
   * @extends module:bajaux/Widget
   */
  return class NumberEditor extends Widget {
    constructor(params) {
      super({
        params,
        defaults: {
          properties: {
            label: 'Number'
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
        <input id="${ id }" type="number" >
      `);

      dom.on('change', 'input', () => { this.setModified(true); });
    }

    /**
     * @param {number} number The number being loaded into this widget
     */
    doLoad(number) {
      this.jq().find('input').val(number);
    }

    /**
     * @returns {number} A number read from the DOM
     */
    doRead() {
      return Number(this.jq().find('input').val());
    }

    /**
     * @returns {string} An id that uniquely identifies this element even if multiple NumberEditors are used on one page
     */
    $createUniqueId() {
      return `number-editor-${ crypto.randomUUID() }`;
    }
  };
});
