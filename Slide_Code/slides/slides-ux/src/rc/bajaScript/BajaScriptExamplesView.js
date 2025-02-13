/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule:slides/rc/bajaScript/BajaScriptExamplesView
 */
/* eslint-env browser */
define([
  'baja!',
  'bajaux/Widget',
  'bajaux/mixin/subscriberMixIn',
  'baja!baja:Component'
], function (
  baja,
  Widget,
  subscriberMixIn
) {
  'use strict';

  const widgetDefaults = () => ({
    properties: {
      rootCssClass: 'bajascript-examples-view'
    }
  });

  return class BajaScriptExamplesView extends Widget {
    constructor(params) {
      super({ params, defaults: widgetDefaults() });
      subscriberMixIn(this);
    }

    doInitialize(dom) {
      dom.html(`
         <div class="wrapper">
          <button type="button" class="add-component">Add Component with name <input type="text" ></button>
          <button type="button" class="remove-component">Remove Component with name <input type="text" ></button>
          <button type="button" class="invoke-action">Invoke Action with Argument <input type="text" ></button>
          <button type="button" class="fire-topic">Fire Topic with Event <input type="text" ></button>
          <button type="button" class="resolve-ord">Resolve ORD <input type="text" ></button>
          <button type="button" class="call-rpc">Call rpc with Argument <input type="text" ></button>
        </div>
      `);

      dom.on('click', '.add-component', () => {
        const component = this.value();
        const name = this.jq().find('.add-component input').val();
        component.add({ slot: name, value: this.$createComponent() });
      });

      dom.on('click', '.remove-component', () => {
        const component = this.value();
        const name = this.jq().find('.remove-component input').val();
        component.remove({ slot: name });
      });

      dom.on('click', '.invoke-action', () => {
        const component = this.value();
        const argument = this.jq().find('.invoke-action input').val();
        component.invoke({ slot: 'print', value: argument });
      });

      dom.on('click', '.fire-topic', () => {
        const component = this.value();
        const eventValue = this.jq().find('.fire-topic input').val();
        component.fire({ slot: 'send', value: eventValue });
      });

      dom.on('click', '.resolve-ord', () => {
        const ord = this.jq().find('.resolve-ord input').val();
        baja.Ord.make(ord)
          .get()
          .then((resolvedOrd) => {
            console.log(resolvedOrd);
          })
          .catch(err => console.error(err));
      });

      dom.on('click', '.call-rpc', () => {
        const component = this.value();
        const argument = this.jq().find('.call-rpc input').val();
        component.rpc('exampleRpc', argument);
      });

      // Prevent click events on inputs nested in buttons from causing buttons to "be clicked"
      dom.on('click', 'input', (event) => {
        event.stopPropagation();
      });
    }

    $createComponent() {
      return baja.$('baja:Component');
    }
  };
});
