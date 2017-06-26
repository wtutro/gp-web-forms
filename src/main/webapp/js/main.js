AUI.add('gp-web-form', function (A) {

        var GPForm = function (portletNamespace, formNode, plid) {
            var instance = this;
            instance.portletNamespace = portletNamespace;
            instance.formNode = formNode;
            instance.plid = plid;
        };

        GPForm.prototype = {
            init: function () {
                var instance = this;
                instance.formNode.on('submit', function (e) {
                    e.preventDefault();
                    instance._submitForm();
                });
            },

            _submitForm: function () {
                var instance = this;

                var hasErrors = false;
                var liferayForm = Liferay.Form.get(instance.formNode.get('id'));

                if (liferayForm) {
                    var validator = liferayForm.formValidator;

                    if (A.instanceOf(validator, A.FormValidator)) {
                        validator.validate();
                        hasErrors = validator.hasErrors();

                        if (hasErrors) {
                            validator.focusInvalidField();
                        }
                    }
                }

                if (!hasErrors) {
                    var data = {
                        "firstName": instance.formNode.one('#' + instance.portletNamespace + 'firstName').val(),
                        "lastName": instance.formNode.one('#' + instance.portletNamespace + 'lastName').val(),
                        "email": instance.formNode.one('#' + instance.portletNamespace + 'email').val(),
                        "comment": instance.formNode.one('#' + instance.portletNamespace + 'comment').val(),
                        "portletId": instance.portletNamespace,
                        "plid": instance.plid
                    };

                    A.io.request('/gp-forms-portlet/rest/webform/submit',
                        {
                            method: 'POST',
                            data: A.JSON.stringify(data),
                            dataType: 'json',
                            headers: {'Content-Type': 'application/json; charset=utf-8'},
                            on: {
                                success: function () {
                                    // form submit has been accepted show the "thank you message"
                                    var data = this.get('responseData');
                                    console.log('on-success-> ' + data)
                                },
                                error: function () {
                                    var data = this.get('responseData');
                                    console.log('on-error-> ' + data)
                                }
                            }
                        }
                    );
                }
            }
        };

        Liferay.Portlet.GPForm = GPForm;
    },
    '',
    {
        requires: ['aui-node', 'aui-io-request', 'liferay-util-window', 'liferay-portlet-url', 'json', 'liferay-form']
    }
);
