module.exports = function(grunt) {

    require('load-grunt-tasks')(grunt);

    grunt.initConfig({
        sass: {
            dev: {
                files: {
                    'public/static/css/output.css' : 'public/scss/output.scss'
                }
            }
        },
        watch: {
            options: {livereload: true},
            sass: {
                files: 'public/scss/**/*.scss',
                tasks: ['sass:dev']
            }
        },
    });

    grunt.registerTask('default', ['sass:dev']);
};

