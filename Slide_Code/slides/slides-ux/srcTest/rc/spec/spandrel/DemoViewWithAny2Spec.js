/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/* eslint-env browser */
define([
  'baja!',
  'bajaux/Widget',
  'nmodule/slides/rc/spandrel/DemoViewWithAny2',
  'jquery',
  'bajaux/util/SaveCommand',
  'baja!slides:Demo'
], function (
  baja,
  Widget,
  DemoViewWithAny2,
  $,
  SaveCommand
) {
  'use strict';

  describe('nmodule/slides/rc/spandrel/DemoViewWithComposedWidgets', function () {
    describe('#constructor', function () {
      it('is a subclass of Widget', function () {
        expect(new DemoViewWithAny2()).toEqual(jasmine.any(Widget));
      });

      it('contains a SaveCommand', function () {
        expect(new DemoViewWithAny2().getCommandGroup().get(0) instanceof SaveCommand).toBe(true);
      });
    });

    describe('#doInitialize', function () {
      let dom, demoViewWidget, numberEditor, stringEditor, booleanEditor;
      const demo = baja.$('slides:Demo');

      beforeEach(() => {
        demoViewWidget = new DemoViewWithAny2();
        dom = $('<div></div>');
        return demoViewWidget.initialize(dom)
          .then(() => demoViewWidget.load(demo))
          .then(() => {
            numberEditor = demoViewWidget.queryWidget('wrapper/intPropertyEditor/numberEditor');
            stringEditor = demoViewWidget.queryWidget('wrapper/stringPropertyEditor/stringEditor');
            booleanEditor = demoViewWidget.queryWidget('wrapper/booleanPropertyEditor/booleanEditor');
          });
      });


      afterEach(() => demoViewWidget.destroy());

      it('has a root CSS class of demo-view', function () {
        expect(demoViewWidget.jq()).toHaveClass('demo-view');
      });

      it('contains editors for all properties on BDemo', function () {
        expect(dom.find('.int-property-editor').length > 0).toBe(true);
        expect(dom.find('.string-property-editor').length > 0).toBe(true);
        expect(dom.find('.boolean-property-editor').length > 0).toBe(true);
      });

      it('has a NumberEditor child widget', function () {
        expect(numberEditor).toBeDefined();
      });

      it('has a StringEditor child widget', function () {
        expect(stringEditor).toBeDefined();
      });

      it('has a BooleanEditor child widget', function () {
        expect(booleanEditor).toBeDefined();
      });

      it('becomes modified when NumberEditor is modified', function () {
        expect(demoViewWidget.isModified()).toBe(false);
        numberEditor.setModified(true);
        expect(demoViewWidget.isModified()).toBe(true);
      });

      it('becomes modified when StringEditor is modified', function () {
        expect(demoViewWidget.isModified()).toBe(false);
        stringEditor.setModified(true);
        expect(demoViewWidget.isModified()).toBe(true);
      });

      it('becomes modified when BooleanEditor is modified', function () {
        expect(demoViewWidget.isModified()).toBe(false);
        booleanEditor.setModified(true);
        expect(demoViewWidget.isModified()).toBe(true);
      });
    });

    describe('#doLoad', function () {
      let dom, demoViewWidget, mountedDemo;

      beforeEach(() => {
        demoViewWidget = new DemoViewWithAny2();
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

      it('updates child widgets with values loaded in', function () {
        const demo = baja.$('slides:Demo');
        demo.setIntProperty(42);
        demo.setStringProperty('test one two three');
        demo.setBooleanProperty(true);

        return demoViewWidget.load(demo)
          .then(() => {
            const numberEditor = demoViewWidget.queryWidget('wrapper/intPropertyEditor/numberEditor');
            const stringEditor = demoViewWidget.queryWidget('wrapper/stringPropertyEditor/stringEditor');
            const booleanEditor = demoViewWidget.queryWidget('wrapper/booleanPropertyEditor/booleanEditor');
            return Promise.all([
              numberEditor.read(),
              stringEditor.read(),
              booleanEditor.read()
            ]);
          })
          .then(([ readNumberValue, readStringValue, readBooleanValue ]) => {
            // we need valueOf() because a baja:Integer containing 42 is not equal to the Number 42
            expect(readNumberValue.valueOf()).toBe(42);
            expect(readStringValue).toBe('test one two three');
            expect(readBooleanValue).toBe(true);
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

    describe('#doSave', function () {
      it('saves value back to proxy component', function () {
        const demo = baja.$('slides:Demo');
        const demoViewWidget = new DemoViewWithAny2();
        const dom = $('<div></div>');

        return demoViewWidget.initialize(dom)
          .then(() => demoViewWidget.load(demo))
          .then(() => {
            const numberEditor = demoViewWidget.queryWidget('wrapper/intPropertyEditor/numberEditor');
            const stringEditor = demoViewWidget.queryWidget('wrapper/stringPropertyEditor/stringEditor');
            const booleanEditor = demoViewWidget.queryWidget('wrapper/booleanPropertyEditor/booleanEditor');

            return Promise.all([
              numberEditor.load(42),
              stringEditor.load('test one two three'),
              booleanEditor.load(true)
            ]);
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
