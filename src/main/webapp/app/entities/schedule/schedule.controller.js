(function() {
    'use strict';

    angular
        .module('schedulingProjectApp')
        .controller('ScheduleController', ScheduleController);

    ScheduleController.$inject = ['$scope', '$state', 'Schedule'];


    function ScheduleController ($scope, $state, Schedule) {
        var vm = this;

        vm.schedules = [];

angular.element(document).ready(function () {
            $('#calendar').fullCalendar({
                    // put your options and callbacks here
                })
        });
    }
})();
