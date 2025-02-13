/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/* eslint-env browser */
define([
  'baja',
  'bajaux/Widget',
  'nmodule/slides/rc/spandrel/editors/NumberEditor',
  'jquery'
], function (
  baja,
  Widget,
  NumberEditor,
  $
) {
  'use strict';


  describe('nmodule/slides/rc/spandrel/editors/NumberEditor', function () {
    describe('#constructor', function () {
      it('is a subclass of Widget', function () {
        expect(new NumberEditor()).toEqual(jasmine.any(Widget));
      });
    });

    describe('#doInitialize', function () {
      let dom, numberEditor;

      beforeEach(() => {
        numberEditor = new NumberEditor();
        dom = $('<div></div>');
        return numberEditor.initialize(dom)
          .then(() => numberEditor.load(30));
      });

      afterEach(() => numberEditor.destroy());

      it('contains a label with default value Number', function () {
        expect(dom.find('label').text()).toBe('Number');
      });

      it('allows changing label text through property', function () {
        const dom = $('<div></div>');
        const numberEditor = new NumberEditor({ properties: { label: 'Test' } });

        return numberEditor.initialize(dom)
          .then(() => numberEditor.load(30))
          .then(() => {
            expect(dom.find('label').text()).toBe('Test');
          })
          .then(() => numberEditor.destroy());
      });

      it('contains one number input', function () {
        expect(dom.find('input').length).toBe(1);
        expect(dom.find('input[type="number"]').length).toBe(1);
      });

      it('creates a unique id for each input', function () {
        const dom2 = $('<div></div>');
        const numberEditor2 = new NumberEditor();

        return numberEditor2.initialize(dom2)
          .then(() => {
            expect(dom.find('input').prop('id')).not.toBe(dom2.find('input').prop('id'));
          })
          .then(() => numberEditor2.destroy());
      });

      it('becomes modified when input changes', function () {
        expect(numberEditor.isModified()).toBe(false);
        dom.find('input').trigger('change');
        expect(numberEditor.isModified()).toBe(true);
      });
    });

    describe('#doLoad', function () {
      let dom, numberEditor;

      beforeEach(() => {
        numberEditor = new NumberEditor();
        dom = $('<div></div>');
        return numberEditor.initialize(dom);
      });

      afterEach(() => numberEditor.destroy());

      it('updates dom with value loaded in', function () {
        return numberEditor.load(30)
          .then(() => {
            expect(dom.find('input').val()).toBe('30');
          });
      });
    });

    describe('#doRead', function () {
      let dom, numberEditor;

      beforeEach(() => {
        numberEditor = new NumberEditor();
        dom = $('<div></div>');
        return numberEditor.initialize(dom)
          .then(() => numberEditor.load(30));
      });

      afterEach(() => numberEditor.destroy());

      it('returns a number', function () {
        return numberEditor.read()
          .then((readValue) => {
            expect(typeof readValue).toBe('number');
          });
      });

      it('returns a value that correctly reflects the DOM', function () {
        dom.find('input').val(42);
        return numberEditor.read()
          .then((readValue) => {
            expect(readValue).toBe(42);
          });
      });
    });
  });
});
