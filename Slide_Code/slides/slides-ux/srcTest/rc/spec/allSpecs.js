/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/* IMPORTANT: All specs must be listed here to run */
define([
  'nmodule/js/rc/jasmine/promiseUtils',

  'nmodule/slidesTest/rc/spec/bajaScript/BajaScriptExamplesViewSpec',

  'nmodule/slidesTest/rc/spec/bajaux/editors/NumberEditorSpec',
  'nmodule/slidesTest/rc/spec/bajaux/editors/StringEditorSpec',
  'nmodule/slidesTest/rc/spec/bajaux/editors/BooleanEditorSpec',
  'nmodule/slidesTest/rc/spec/bajaux/DemoViewWithFeSpec',
  'nmodule/slidesTest/rc/spec/bajaux/SimpleWidgetSpec',
  'nmodule/slidesTest/rc/spec/bajaux/DemoViewSpec',
  'nmodule/slidesTest/rc/spec/bajaux/DemoViewWithComposedWidgetsSpec',

  'nmodule/slidesTest/rc/spec/spandrel/DemoViewSpec',
  'nmodule/slidesTest/rc/spec/spandrel/editors/NumberEditorSpec',
  'nmodule/slidesTest/rc/spec/spandrel/editors/StringEditorSpec',
  'nmodule/slidesTest/rc/spec/spandrel/editors/BooleanEditorSpec',
  'nmodule/slidesTest/rc/spec/spandrel/DemoViewWithComposedWidgetsSpec',
  'nmodule/slidesTest/rc/spec/spandrel/DemoViewWithAnySpec',
  'nmodule/slidesTest/rc/spec/spandrel/DemoViewWithAny2Spec'
], function (
  promiseUtils
) {
  'use strict';
  beforeEach(function () {
    promiseUtils.addCustomMatchers(this);
  });
});



