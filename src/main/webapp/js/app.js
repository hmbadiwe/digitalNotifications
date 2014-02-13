/**
 * Created with IntelliJ IDEA.
 * User: hmbadiwe
 * Date: 2/13/14
 * Time: 9:04 AM
 * To change this template use File | Settings | File Templates.
 */

var digiNotifApp = angular.module( 'digiNotifApp', ['ngResource']) ;

digiNotifApp.directive('ckEditor', function() {
    return {
        require: '?ngModel',
        link: function(scope, elm, attr, ngModel) {
            var ck = CKEDITOR.replace(elm[0],
                {
                    toolbar:
                        [
                            { name: 'document', items : [ 'Source'] },
                            { name: 'forms', items: [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField' ] },
                            '/',
                            { name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
                            { name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
                            { name: 'editing', items : [ 'Find','Replace','-','SpellChecker', 'Scayt' ] },
                            { name: 'paragraph', items : [
                             'NumberedList','BulletedList','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock' ] },
                            { name: 'links', items : [] },
                            { name: 'insert', items : [ 'SpecialChar' ] },
                             '/',
                            { name: 'styles', items : [ 'Styles','Format','Font','FontSize' ] },
                            { name: 'colors', items : [] }
                        ]
                    ,
                    height: '290px',
                    width: '99%'
                }
            );
            function updateModel() {
                scope.$apply(function() {
                    ngModel.$setViewValue(ck.getData());
                });
            }

            if(ngModel){
                ck.on('change', updateModel);
                ck.on('key', updateModel);
                ck.on('dataReady', updateModel);
                ck.on('paste', updateModel);
                ck.on('instanceReady', function() {
                    ck.setData(ngModel.$viewValue);
                });

                ngModel.$render = function(value) {
                    ck.setData(ngModel.$viewValue);
                };
            }


            elm.bind('$destroy', function() { ck.destroy(); });
        }
    };
})


