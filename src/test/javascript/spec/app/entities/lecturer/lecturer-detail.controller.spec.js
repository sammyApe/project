'use strict';

describe('Controller Tests', function() {

    describe('Lecturer Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockLecturer, MockCourse, MockDayTime, MockSession, MockSchedule;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockLecturer = jasmine.createSpy('MockLecturer');
            MockCourse = jasmine.createSpy('MockCourse');
            MockDayTime = jasmine.createSpy('MockDayTime');
            MockSession = jasmine.createSpy('MockSession');
            MockSchedule = jasmine.createSpy('MockSchedule');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'Lecturer': MockLecturer,
                'Course': MockCourse,
                'DayTime': MockDayTime,
                'Session': MockSession,
                'Schedule': MockSchedule
            };
            createController = function() {
                $injector.get('$controller')("LecturerDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'schedulingProjectApp:lecturerUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
