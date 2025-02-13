/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/* eslint-env browser */

define([
  'bajaux/Widget',
  'nmodule/slides/rc/bajaux/SimpleWidget'
], function (
  Widget,
  SimpleWidget
) {
  'use strict';

  describe('nmodule/slides/rc/bajaux/SimpleWidget', function () {
    describe('#constructor', function () {
      it('is a subclass of Widget', function () {
        expect(new SimpleWidget()).toEqual(jasmine.any(Widget));
      });

      it('has a property named example with a default value of "defaultValue"', function () {
        expect(new SimpleWidget().properties().getValue('example')).toEqual('defaultValue');
      });

      it('accepts non-default values for example', function () {
        const simpleWidget = new SimpleWidget({ properties: { example: 'test' } });
        expect(simpleWidget.properties().getValue('example')).toEqual('test');
      });

      it('contains an ExampleCommand', function () {
        expect(new SimpleWidget().getCommandGroup().get(0).toDisplayName()).toBeResolvedWith('Example Command');
      });
    });

    describe('#getExampleProperty', function () {
      it('gets default example property', function () {
        expect(new SimpleWidget().getExampleProperty()).toEqual('defaultValue');
      });

      it('gets non-default example property', function () {
        const simpleWidget = new SimpleWidget({ properties: { example: 'test' } });
        expect(simpleWidget.getExampleProperty()).toEqual('test');
      });
    });
  });
});
