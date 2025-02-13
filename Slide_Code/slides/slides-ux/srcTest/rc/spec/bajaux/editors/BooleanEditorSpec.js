/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/* eslint-env browser */
define([
  'baja',
  'bajaux/Widget',
  'nmodule/slides/rc/bajaux/editors/BooleanEditor',
  'jquery'
], function (
  baja,
  Widget,
  BooleanEditor,
  $
) {
  'use strict';

  describe('nmodule/slides/rc/bajaux/editors/BooleanEditor', function () {
    describe('#constructor', function () {
      it('is a subclass of Widget', function () {
        expect(new BooleanEditor()).toEqual(jasmine.any(Widget));
      });
    });

    describe('#doInitialize', function () {
      let dom, booleanEditor;

      beforeEach(() => {
        booleanEditor = new BooleanEditor();
        dom = $('<div></div>');
        return booleanEditor.initialize(dom);
      });

      afterEach(() => booleanEditor.destroy());

      it('contains a label with default value Boolean', function () {
        expect(dom.find('label').text()).toBe('Boolean');
      });

      it('allows changing label text through property', function () {
        const dom = $('<div></div>');
        const booleanEditor = new BooleanEditor({ properties: { label: 'Test' } });

        return booleanEditor.initialize(dom)
          .then(() => {
            expect(dom.find('label').text()).toBe('Test');
          })
          .then(() => booleanEditor.destroy());
      });

      it('contains one checkbox input', function () {
        expect(dom.find('input').length).toBe(1);
        expect(dom.find('input[type="checkbox"]').length).toBe(1);
      });

      it('creates a unique id for each input', function () {
        const dom2 = $('<div></div>');
        const booleanEditor2 = new BooleanEditor();

        return booleanEditor2.initialize(dom2)
          .then(() => {
            expect(dom.find('input').prop('id')).not.toBe(dom2.find('input').prop('id'));
          })
          .then(() => booleanEditor2.destroy());
      });

      it('becomes modified when input changes', function () {
        expect(booleanEditor.isModified()).toBe(false);
        dom.find('input').trigger('change');
        expect(booleanEditor.isModified()).toBe(true);
      });
    });

    describe('#doLoad', function () {
      let dom, booleanEditor;

      beforeEach(() => {
        booleanEditor = new BooleanEditor();
        dom = $('<div></div>');
        return booleanEditor.initialize(dom);
      });

      afterEach(() => booleanEditor.destroy());

      it('updates dom with value loaded in', function () {
        return booleanEditor.load(true)
          .then(() => {
            expect(dom.find('input').prop('checked')).toBe(true);
          });
      });
    });

    describe('#doRead', function () {
      let dom, booleanEditor;

      beforeEach(() => {
        booleanEditor = new BooleanEditor();
        dom = $('<div></div>');
        return booleanEditor.initialize(dom)
          .then(() => booleanEditor.load(true));
      });

      afterEach(() => booleanEditor.destroy());

      it('returns a boolean', function () {
        return booleanEditor.read()
          .then((readValue) => {
            expect(typeof readValue).toBe('boolean');
          });
      });

      it('returns a value that correctly reflects the DOM', function () {
        dom.find('input').prop('checked', false);
        return booleanEditor.read()
          .then((readValue) => {
            expect(readValue).toBe(false);
          });
      });
    });
  });
});
