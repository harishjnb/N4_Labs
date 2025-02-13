/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/* jshint node: true *//* eslint-env node */

"use strict";

const loadTasksRelative = require('grunt-niagara/lib/loadTasksRelative');

const SRC_FILES = [
  'src/rc/**/*.js',
  'Gruntfile.js',
  '!**/*.built.js',
  '!**/*.built.min.js'
];
const TEST_FILES = [
  'srcTest/rc/**/*.js'
];
const JS_FILES = SRC_FILES.concat(TEST_FILES);
const ALL_FILES = JS_FILES.concat('src/rc/**/*.css');

module.exports = function runGrunt(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),

    jsdoc: {
    },
    eslint: {
      src: JS_FILES,
      options: {
        plugins: [ 'react' ]
      }
    },
    babel: {
      options: {
        presets: [ '@babel/preset-env' ],
        plugins: [ '@babel/plugin-transform-react-jsx' ]
      },
      coverage: {
        options: {
          plugins: [ '@babel/plugin-transform-react-jsx', 'istanbul' ]
        }
      }
    },
    watch: {
      src: ALL_FILES
    },
    karma: {},
    requirejs: {},
    niagara: {
      station: {
        stationName: 'slides',
        forceCopy: true,
        sourceStationFolder: './srcTest/rc/stations/slidesUnitTest'
      }
    }
  });

  loadTasksRelative(grunt, 'grunt-niagara');
};
