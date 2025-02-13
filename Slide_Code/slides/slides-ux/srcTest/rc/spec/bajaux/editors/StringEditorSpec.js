/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/* eslint-env browser */
define([
  'baja',
  'bajaux/Widget',
  'nmodule/slides/rc/bajaux/editors/StringEditor',
  'jquery'
], function (
  baja,
  Widget,
  StringEditor,
  $
) {
  'use strict';

  describe('nmodule/slides/rc/bajaux/editors/StringEditor', function () {
    describe('#constructor', function () {
      it('is a subclass of Widget', function () {
        expect(new StringEditor()).toEqual(jasmine.any(Widget));
      });
    });

    describe('#doInitialize', function () {
      let dom, stringEditor;

      beforeEach(() => {
        stringEditor = new StringEditor();
        dom = $('<div></div>');
        return stringEditor.initialize(dom);
      });

      afterEach(() => stringEditor.destroy());

      it('contains a label with default value String', function () {
        expect(dom.find('label').text()).toBe('String');
      });

      it('allows changing label text through property', function () {
        const dom = $('<div></div>');
        const stringEditor = new StringEditor({ properties: { label: 'Test' } });

        return stringEditor.initialize(dom)
          .then(() => {
            expect(dom.find('label').text()).toBe('Test');
          })
          .then(() => stringEditor.destroy());
      });

      it('contains one text input', function () {
        expect(dom.find('input').length).toBe(1);
        expect(dom.find('input[type="text"]').length).toBe(1);
      });

      it('creates a unique id for each input', function () {
        const dom2 = $('<div></div>');
        const stringEditor2 = new StringEditor();

        return stringEditor2.initialize(dom2)
          .then(() => {
            expect(dom.find('input').prop('id')).not.toBe(dom2.find('input').prop('id'));
          })
          .then(() => stringEditor2.destroy());
      });

      it('becomes modified when input changes', function () {
        expect(stringEditor.isModified()).toBe(false);
        dom.find('input').trigger('change');
        expect(stringEditor.isModified()).toBe(true);
      });
    });

    describe('#doLoad', function () {
      let dom, stringEditor;

      beforeEach(() => {
        stringEditor = new StringEditor();
        dom = $('<div></div>');
        return stringEditor.initialize(dom);
      });

      afterEach(() => stringEditor.destroy());

      it('updates dom with value loaded in', function () {
        return stringEditor.load('abc')
          .then(() => {
            expect(dom.find('input').val()).toBe('abc');
          });
      });
    });

    describe('#doRead', function () {
      let dom, stringEditor;

      beforeEach(() => {
        stringEditor = new StringEditor();
        dom = $('<div></div>');
        return stringEditor.initialize(dom)
          .then(() => stringEditor.load('abc'));
      });

      afterEach(() => stringEditor.destroy());

      it('returns a string', function () {
        return stringEditor.read()
          .then((readValue) => {
            expect(typeof readValue).toBe('string');
          });
      });

      it('returns a value that correctly reflects the DOM', function () {
        dom.find('input').val('abc');
        return stringEditor.read()
          .then((readValue) => {
            expect(readValue).toBe('abc');
          });
      });
    });
  });
});
