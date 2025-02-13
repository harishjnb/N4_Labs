/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule/slides/rc/spandrel/editors/StringEditor
 */
/** @jsx spandrel.jsx */
/* eslint-env browser */
define([
  'bajaux/spandrel'
], function (
  spandrel
) {
  'use strict';

  /**
   * @class
   * @alias module:nmodule/slides/rc/spandrel/editors/StringEditor
   * @extends module:bajaux/spandrel
   */
  return class StringEditor extends spandrel((string, { self }) => {
    const id = self.$createUniqueId();
    return [
      <label htmlFor={id}>{self.properties().getValue('label')}</label>,
      <input id={id} type="text" value={string} onChange={() => self.setModified(true)} />
    ];
  }) {

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
     * @returns {string} A string read from the DOM
     */
    doRead() {
      return this.jq().find('input').val();
    }

    /**
     * @returns {string} An id that uniquely identifies this element even if multiple NumberEditors are used on one page
     */
    $createUniqueId() {
      return `number-editor-${ crypto.randomUUID() }`;
    }
  };
});
