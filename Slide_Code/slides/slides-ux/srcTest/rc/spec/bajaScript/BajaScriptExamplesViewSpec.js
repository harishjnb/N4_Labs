/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/* eslint-env browser */

define([
  'baja!',
  'bajaux/Widget',
  'nmodule/slides/rc/bajaScript/BajaScriptExamplesView',
  'jquery',
  'nmodule/js/rc/jasmine/promiseUtils',
  'baja!slides:BajaScriptExamples,baja:Component'
], function (
  baja,
  Widget,
  BajaScriptExamplesView,
  $,
  promiseUtils
) {
  'use strict';

  describe('nmodule/slides/rc/bajaScript/BajaScriptExamplesView', function () {
    let dom, bajaScriptExamplesView, bajaScriptExamples;

    function removeAllDynamicSlots(component) {
      const dynamicSlotNames = [];
      component.getSlots().properties().dynamic().each((slot) => {
        dynamicSlotNames.push(slot.getName());
      });
      const removePromises = dynamicSlotNames.map((slotName) => component.remove(slotName));
      return Promise.all(removePromises);
    }

    beforeEach(() => {
      dom = $('<div></div>');
      bajaScriptExamplesView = new BajaScriptExamplesView();

      // The below ORD resolves to a component added to the unit testing station at rc/stations/slides/slidesUnitTest
      return bajaScriptExamplesView.initialize(dom)
        .then(() => baja.Ord.make('station:|slot:BajaScriptExamplesTest/BajaScriptExamples').get())
        .then((mountedBajaScriptExamples) => {
          bajaScriptExamples = mountedBajaScriptExamples;
          return bajaScriptExamplesView.load(bajaScriptExamples);
        });
    });

    afterEach(() => bajaScriptExamplesView.destroy());

    describe('#constructor', function () {
      it('is a subclass of Widget', function () {
        expect(bajaScriptExamplesView).toEqual(jasmine.any(Widget));
      });

      it('has a subscriber mixin', function () {
        expect(bajaScriptExamplesView.hasMixIn('subscriber')).toBe(true);
      });
    });

    describe('add component button', function () {
      let addButton;

      beforeEach(() => {
        addButton = dom.find('button.add-component');
      });

      afterEach(() => removeAllDynamicSlots(bajaScriptExamples));

      it('exists', function () {
        expect(addButton.length > 0).toBe(true);
      });

      it('adds a component on click', function () {
        const numProperties = bajaScriptExamples.getSlots().properties().getSize();
        addButton.find('input').val('test?');
        addButton.click();
        return promiseUtils.waitForTrue(
          () => bajaScriptExamples.getSlots().properties().getSize() === numProperties + 1,
          "adding component after clicking add button");
      });
    });

    describe('remove component button', function () {
      let removeButton;

      beforeEach(() => {
        removeButton = dom.find('button.remove-component');
        return removeAllDynamicSlots(bajaScriptExamples)
          .then(() => bajaScriptExamples.add({ slot: 'removeTest', value: baja.$('baja:Component') }));
      });

      it('exists', function () {
        expect(removeButton.length > 0).toBe(true);
      });

      it('removes a component on click', function () {
        const numProperties = bajaScriptExamples.getSlots().properties().getSize();
        removeButton.find('input').val('removeTest');
        removeButton.click();
        return promiseUtils.waitForTrue(
          () => bajaScriptExamples.getSlots().properties().getSize() === numProperties - 1,
          "removing component after clicking remove button"
        );
      });
    });

    describe('invoke action button', function () {
      let invokeActionButton;

      beforeEach(() => {
        invokeActionButton = dom.find('button.invoke-action');
      });

      it('exists', function () {
        expect(invokeActionButton.length > 0).toBe(true);
      });

      it('invokes action on click', function () {
        spyOn(bajaScriptExamples, 'invoke').andResolve();
        invokeActionButton.find('input').val('invoke test');
        invokeActionButton.click();
        expect(bajaScriptExamples.invoke).toHaveBeenCalledWith({ slot: 'print', value: 'invoke test' });
      });
    });

    describe('fire topic button', function () {
      let fireTopicButton;

      beforeEach(() => {
        fireTopicButton = dom.find('button.fire-topic');
      });

      it('exists', function () {
        expect(fireTopicButton.length > 0).toBe(true);
      });

      it('fires topic on click', function () {
        spyOn(bajaScriptExamples, 'fire').andResolve();
        fireTopicButton.find('input').val('fire test');
        fireTopicButton.click();
        expect(bajaScriptExamples.fire).toHaveBeenCalledWith({ slot: 'send', value: 'fire test' });
      });
    });

    describe('resolve ORD button', function () {
      let resolveOrdButton;

      beforeEach(() => {
        resolveOrdButton = dom.find('button.resolve-ord');
      });

      it('exists', function () {
        expect(resolveOrdButton.length > 0).toBe(true);
      });

      it('resolves ORD on click', function () {
        let loggedToConsole = false;
        spyOn(console, 'log').andCallFake(() => { loggedToConsole = true; });
        resolveOrdButton.find('input').val('station:|service:baja:UserService');
        resolveOrdButton.click();
        return promiseUtils.waitForTrue(
          () => loggedToConsole,
          'ord to resolve after clicking resolve ORD button'
        );
      });
    });

    describe('call RPC button', function () {
      let callRpcButton;

      beforeEach(() => {
        callRpcButton = dom.find('button.call-rpc');
      });

      it('exists', function () {
        expect(callRpcButton.length > 0).toBe(true);
      });

      it('calls RPC on click', function () {
        spyOn(bajaScriptExamples, 'rpc').andResolve();
        callRpcButton.find('input').val('call RPC test');
        callRpcButton.click();
        expect(bajaScriptExamples.rpc).toHaveBeenCalledWith('exampleRpc', 'call RPC test');
      });
    });
  });
});
