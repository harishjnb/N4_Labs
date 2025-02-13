/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

define([
    'bajaux/Widget',
    'nmodule/slides/rc/bajaux/SimpleWidget'
], function (
Widget,
SimpleWidget) {
    'use strict';

    return class AnotherWidget extends Widget {
        makeSimpleWidget() {
            return new SimpleWidget({
                properties: {
                    example: 'value'
                }
            });
        }
    };
});
