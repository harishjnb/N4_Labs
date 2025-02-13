/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule/slides/rc/bajaux/SimpleWidget
 */
/* eslint-env browser */
define([
  'bajaux/Widget',
  'bajaux/commands/Command'
], function (
  Widget,
  Command
) {
  'use strict';

  /**
   * @class
   * @alias module:nmodule/slides/rc/bajaux/SimpleWidget
   * @extends module:bajaux/Widget
   */
  return class SimpleWidget extends Widget {
    constructor(params) {
      super({
        params,
        defaults: {
          properties: {
            example: 'defaultValue'
          }
        }
      });

      const exampleCommand = new Command({
        displayName: 'Example Command',
        description: 'Example Command Description',
        icon: 'module://icons/x16/heart.png',
        func: () => { console.log('Example Command run!'); }
      });

      this.getCommandGroup().add(exampleCommand);
    }

    /**
     * @returns {string} The value of the property named example
     */
    getExampleProperty() {
      const properties = this.properties();
      return properties.getValue('example');
    }
  };
});
