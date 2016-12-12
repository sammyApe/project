(function() {
    'use strict';

    angular
        .module('schedulingProjectApp')
        .controller('ScheduleController', ScheduleController);

    ScheduleController.$inject = ['$scope', '$state', 'Schedule','Lecturer'];


    function ScheduleController ($scope, $state, Schedule,Lecturer) {
        var vm = this;

        vm.schedules = [];

        vm.Lecturers=[];

angular.element(document).ready(function () {
            $('#calendar').fullCalendar({
                    // put your options and callbacks here
                })
        });

         loadAll();

                function loadAll() {
                debugger;
                    Lecturer.query(function(result) {
                        vm.lecturers = result;
                    });
                }



    }
})();
