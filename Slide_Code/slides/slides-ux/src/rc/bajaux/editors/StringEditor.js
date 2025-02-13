/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule/slides/rc/bajaux/editors/StringEditor
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
   * @alias module:nmodule/slides/rc/bajaux/editors/StringEditor
   * @extends module:bajaux/Widget
   */
  return class StringEditor extends Widget {
    constructor(params) {
      super({
        params,
        defaults: {
          properties: {
            label: 'String'
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
        <input id="${ id }" type="text" >
      `);

      dom.on('change', 'input', () => { this.setModified(true); });
    }

    /**
     * @param {string} string The string being loaded into this widget
     */
    doLoad(string) {
      this.jq().find('input').val(string);
    }

    /**
     * @returns {string} A string read from the DOM
     */
    doRead() {
      return this.jq().find('input').val();
    }

    /**
     * @returns {string} An id that uniquely identifies this element even if multiple StringEditors are used on one page
     */
    $createUniqueId() {
      return `string-editor-${ crypto.randomUUID() }`;
    }
  };
});
