/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/* eslint-env browser */
define([
  'baja!',
  'bajaux/Widget',
  'Promise'
], function (
  baja,
  Widget,
  Promise
) {
  'use strict';

  /**
   * @class
   * @alias module:nmodule/devTrafficLights/rc/NumericWritableEditorWidget
   * @extends module:bajaux/Widget
   */
  return class NumericWritableEditorWidget extends Widget {

    /**
     * @param {jquery} dom A jQuery wrapper around the DOM node into which this widget is initialized
     */
    doInitialize(dom) {
      // Set up the contents of our DOM node
      dom.html(`
        <div style="max-width: 40rem; margin-inline: auto; display: flex; flex-direction: column; gap: 1rem; align-items: center;">
          <div class="ord-loader">
            <input type="text" placeholder="station:|slot:/" >
            <button type="button" class="load">Load</button>
          </div>
          <div class="value">
          </div>
          <div class="buttons">
            <button type="button" class="increment">Increment</button>
            <button type="button" class="decrement">Decrement</button>
          </div>
        </div>
      `);

      // Subscribe to the user-entered ORD when the Load button is clicked
      dom.on('click', '.load', () => {
        const valueDiv = dom.find('.value');
        const ord = dom.find('.ord-loader input').val();

        if (ord.length === 0) {
          alert('Please enter a valid ORD');
          return;
        }

        this.$initializeSubscriber()
          .then(() => makeOrd(ord).get({ subscriber: this.$subscriber }))
          .then((numericWritable) => {
            if (!numericWritable.getType().is('control:NumericWritable')) {
              throw new Error('Entered ORD is not for a NumericWritable');
            }

            this.$loadedNumericWritable = numericWritable;
            valueDiv.text(this.$loadedNumericWritable.getOut());
          })
          .catch((err) => alert(err));
      });

      // Increment the loaded NumericWritable
      dom.on('click', '.increment', () => {
        if (!this.$loadedNumericWritable) {
          alert('Error: no NumericWritable loaded');
          return;
        }

        const currentValue = this.$loadedNumericWritable.getOut().getValue();

        invokeSet(this.$loadedNumericWritable, currentValue + 1)
          .catch((err) => alert(err));
      });

      // Decrement the loaded NumericWritable
      dom.on('click', '.decrement', () => {
        if (!this.$loadedNumericWritable) {
          alert('Error: no NumericWritable loaded');
          return;
        }

        const currentValue = this.$loadedNumericWritable.getOut().getValue();

        invokeSet(this.$loadedNumericWritable, currentValue - 1)
          .catch((err) => alert(err));
      });

      /**
       * @param {String} ordString The string representation of an ORD to lookup
       * @returns {*} A baja:Ord
       */
      function makeOrd(ordString) {
        // TODO: Create an ORD from the ordString and return it
        return baja.Ord.make(ordString);
      }

      /**
       *
       * @param {*} numericWritable A control:NumericWritable
       * @param {Number} newValue A value to set the numericWritable to
       * @returns {Promise} A Promise that resolves once the set action has been invoked
       */
      function invokeSet(numericWritable, newValue) {
        // TODO: Invoke the set action on the numericWritable with newValue as the argument
        //return numericWritable.set(newValue);
        return numericWritable.invoke({
                slot: 'set',
                value : newValue
        });

      }
    }

    /**
     * Unsubscribe from anything we're still subscribed to when this widget is destroyed
     */
    doDestroy() {
      return this.$unsubscribe(this.$subscriber);
    }

    /**
     * Set up our Subscriber to update the DOM when the value it's subscribed to changes
     * @returns {Promise} A Promise that resolves when the new Subscriber is initialized
     */
    $initializeSubscriber() {
      const valueDiv = this.jq().find('.value');

      const unsubscribe = () => {
        return this.$unsubscribe(this.$subscriber);
      };

      const initialize = () => {
        this.$subscriber = new baja.Subscriber();
        this.$subscriber.attach('changed', function (prop) {
          if (prop.getName() === 'out') {
            valueDiv.text(this.getOut());
          }
        });
      };

      if (this.$subscriber) {
        return unsubscribe()
          .then(() => initialize());
      }

      initialize();
      return Promise.resolve();
    }

    /**
     * Unsubscribe a subscriber from everything it's subscribed to and detach from all component events.
     *
     * @param {baja.Subscriber} subscriber The subscriber to unsubscribe
     * @returns {Promise} A Promise that resolves when the subscriber is unsubscribed
     */
    $unsubscribe(subscriber) {
      if (!subscriber) {
        return Promise.resolve();
      }

      subscriber.detach();
      return subscriber.unsubscribeAll();
    }
  };
});
