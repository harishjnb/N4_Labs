/*
 *  Copyright 2023 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/**
 * @module nmodule/devTrafficLight/rc/TrafficLightWidget
 */
/* eslint-env browser */
define([
  'baja!',
  'bajaux/Widget',
  'bajaux/mixin/subscriberMixIn',
  'bajaux/util/SaveCommand',
  'jquery',
  'baja!devTrafficLights:TrafficLight,devTrafficLights:TrafficLightState',
  'css!nmodule/devTrafficLights/rc/TrafficLightWidget'
], function (
  baja,
  Widget,
  subscriberMixIn,
  SaveCommand,
  $
) {
  'use strict';

  /**
   * A widget that allows viewing and editing the state slot of a devTrafficLights:TrafficLight
   *
   * @class
   * @alias module:nmodule/devTrafficLights/rc/TrafficLightWidget
   * @extends module:bajaux/Widget
   */
  return class TrafficLightWidget extends Widget {
    constructor(params) {
      super({
        params,
        defaults: {
          properties: {
            rootCssClass: 'traffic-light-widget'
          }
        }
      });
      subscriberMixIn(this);
      this.getCommandGroup().add(new SaveCommand());
    }

    /**
     * @param {jQuery} dom A jQuery wrapper around the dom node into which this widget is initialized
     */
    doInitialize(dom) {
      dom.html(`
        <svg width="100%" height="100%">
          <rect x="1" y="1" width="38" height="108" class="light-container"/>
          <circle cx="20" cy="20" r="15" class="light red-light"/>
          <circle cx="20" cy="52" r="15" class="light yellow-light"/>
          <circle cx="20" cy="88" r="15" class="light green-light"/>
        </svg>
      `);

      this.getSubscriber().attach("changed", (property) => {
        if (property.getName() === "state") {
          this.$updateDom(this.value());
        }
      });

      const that = this;
      dom.on('click', '.light', function () {
        dom.find('.light').removeClass('selected');
        $(this).addClass('selected');
        that.setModified(true);
      });
    }

    /**
     * @param {*} trafficLight A devTrafficLights:TrafficLight instance
     */
    doLoad(trafficLight) {
      this.$updateDom(trafficLight);
    }

    /**
     * @returns {*} A devTrafficLights:TrafficLight instance constructed from the state of the DOM
     */
    doRead() {
      const selectedLight = this.jq().find('.light.selected');
      if (selectedLight.length === 0) {
        return null;
      }

      const trafficLight = baja.$('devTrafficLights:TrafficLight');
      const trafficLightState = baja.$('devTrafficLights:TrafficLightState');

      if (selectedLight.hasClass('red-light')) {
        trafficLight.setState(trafficLightState.get('red'));
      } else if (selectedLight.hasClass('yellow-light')) {
        trafficLight.setState(trafficLightState.get('yellow'));
      } else if (selectedLight.hasClass('green-light')) {
        trafficLight.setState(trafficLightState.get('green'));
      }

      return trafficLight;
    }

    /**
     * @param trafficLight The devTrafficLights:TrafficLight instance returned from doRead()
     * @returns {Promise} A Promise that resolves once the state has been saved back to the station
     */
    doSave(trafficLight) {
      return this.value().transition(trafficLight.getState());
    }

    $updateDom(trafficLight) {
      const enumValue = trafficLight.getState().getTag();

      this.jq().find('.light').removeClass([ 'selected', 'active' ]);

      switch (enumValue) {
        case ("red"):
          this.jq().find('.red-light').addClass('active');
          break;
        case ("yellow"):
          this.jq().find('.yellow-light').addClass('active');
          break;
        case ("green"):
          this.jq().find('.green-light').addClass('active');
          break;
      }
    }
  };
});
