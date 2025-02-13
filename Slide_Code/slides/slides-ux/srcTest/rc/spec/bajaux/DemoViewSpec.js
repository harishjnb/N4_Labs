/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/* eslint-env browser */
define([
  'baja!',
  'bajaux/Widget',
  'nmodule/slides/rc/bajaux/DemoView',
  'jquery',
  'bajaux/util/SaveCommand',
  'baja!slides:Demo'
], function (
  baja,
  Widget,
  DemoView,
  $,
  SaveCommand
) {
  'use strict';

  describe('nmodule/slides/rc/bajaux/DemoView', function () {
    describe('#constructor', function () {
      it('is a subclass of Widget', function () {
        expect(new DemoView()).toEqual(jasmine.any(Widget));
      });

      it('has a subscriber mixin', function () {
        expect(new DemoView().hasMixIn('subscriber')).toBe(true);
      });

      it('contains a SaveCommand', function () {
        expect(new DemoView().getCommandGroup().get(0) instanceof SaveCommand).toBe(true);
      });
    });

    describe('#doInitialize', function () {
      let dom, demoViewWidget;

      beforeEach(() => {
        demoViewWidget = new DemoView();
        dom = $('<div></div>');
        return demoViewWidget.initialize(dom);
      });

      afterEach(() => demoViewWidget.destroy());

      it('has a root CSS class of demo-view', function () {
        expect(demoViewWidget.jq()).toHaveClass('demo-view');
      });

      it('contains inputs for all properties on BDemo', function () {
        expect(dom.find('.int-property-editor input').length > 0).toBe(true);
        expect(dom.find('.string-property-editor input').length > 0).toBe(true);
        expect(dom.find('.boolean-property-editor input').length > 0).toBe(true);
      });

      it('becomes modified when int editor changes', function () {
        expect(demoViewWidget.isModified()).toBe(false);
        dom.find('.int-property-editor input').trigger('change');
        expect(demoViewWidget.isModified()).toBe(true);
      });

      it('becomes modified when string editor changes', function () {
        expect(demoViewWidget.isModified()).toBe(false);
        dom.find('.string-property-editor input').trigger('change');
        expect(demoViewWidget.isModified()).toBe(true);
      });

      it('becomes modified when boolean editor changes', function () {
        expect(demoViewWidget.isModified()).toBe(false);
        dom.find('.boolean-property-editor input').trigger('change');
        expect(demoViewWidget.isModified()).toBe(true);
      });
    });

    describe('#doLoad', function () {
      let dom, demoViewWidget, mountedDemo;

      beforeEach(() => {
        demoViewWidget = new DemoView();
        dom = $('<div></div>');
        return demoViewWidget.initialize(dom);
      });

      beforeEach(() => {
        // This component with slotPath /DemoTests/demo was manually added to the station in
        // srcTest/rc/stations/slidesUnitTest. By convention we also include the underlying file.xml to make reviewing
        // diffs easier
        return baja.Ord.make("station:|slot:/DemoTests/demo").get()
          .then((demo) => {
            mountedDemo = demo;
            return Promise.all([
              mountedDemo.setIntProperty(0),
              mountedDemo.setStringProperty('some value'),
              mountedDemo.setBooleanProperty(false)
            ]);
          });
      });

      afterEach(() => demoViewWidget.destroy());

      it('updates dom with values loaded in', function () {
        const demo = baja.$('slides:Demo');
        demo.setIntProperty(42);
        demo.setStringProperty('test one two three');
        demo.setBooleanProperty(true);

        return demoViewWidget.load(demo)
          .then(() => {
            expect(dom.find('.int-property-editor input').val()).toBe('42');
            expect(dom.find('.string-property-editor input').val()).toBe('test one two three');
            expect(dom.find('.boolean-property-editor input').prop('checked')).toBe(true);
          });
      });

      it('is subscribed to the value loaded in', function () {
        return demoViewWidget.load(mountedDemo)
          .then(() =>
            Promise.all([
              mountedDemo.setIntProperty(42),
              mountedDemo.setStringProperty('test one two three'),
              mountedDemo.setBooleanProperty(true)
            ])
          )
          .then(() => {
            expect(dom.find('.int-property-editor input').val()).toBe('42');
            expect(dom.find('.string-property-editor input').val()).toBe('test one two three');
            expect(dom.find('.boolean-property-editor input').prop('checked')).toBe(true);
          });
      });
    });

    describe('#doRead', function () {
      let dom, demoViewWidget;
      const demo = baja.$('slides:Demo');

      beforeEach(() => {
        demoViewWidget = new DemoView();
        dom = $('<div></div>');
        return demoViewWidget.initialize(dom)
          .then(() => demoViewWidget.load(demo));
      });

      afterEach(() => demoViewWidget.destroy());

      it('return a slides:Demo instance', function () {
        return demoViewWidget.read()
          .then((readValue) => {
            expect(readValue.getType().is('slides:Demo')).toBe(true);
          });
      });

      it('returns a value that correctly reflects the DOM', function () {
        dom.find('.int-property-editor input').val(42);
        dom.find('.string-property-editor input').val('test one two three');
        dom.find('.boolean-property-editor input').prop('checked', true);

        return demoViewWidget.read()
          .then((readValue) => {
            expect(readValue.getIntProperty()).toBe(42);
            expect(readValue.getStringProperty()).toBe('test one two three');
            expect(readValue.getBooleanProperty()).toBe(true);
          });
      });
    });

    describe('#doSave', function () {
      it('saves value back to proxy component', function () {
        const demo = baja.$('slides:Demo');
        const demoViewWidget = new DemoView();
        const dom = $('<div></div>');

        return demoViewWidget.initialize(dom)
          .then(() => demoViewWidget.load(demo))
          .then(() => {
            dom.find('.int-property-editor input').val(42);
            dom.find('.string-property-editor input').val('test one two three');
            dom.find('.boolean-property-editor input').prop('checked', true);
          })
          .then(() => demoViewWidget.save())
          .then(() => {
            expect(demo.getIntProperty()).toBe(42);
            expect(demo.getStringProperty()).toBe('test one two three');
            expect(demo.getBooleanProperty()).toBe(true);
          });
      });
    });
  });
});
