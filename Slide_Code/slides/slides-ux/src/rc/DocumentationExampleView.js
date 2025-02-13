/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

define([
  'bajaux/Widget'
], function (
  Widget
) {
  'use strict';

  return class DocumentationExampleView extends Widget {
    doInitialize(dom) {
      dom.html('<p>This is a custom view on slides:DocumentationExample</p>');
    }
  };
});
