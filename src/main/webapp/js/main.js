AUI.add('gp-web-form', function (A) {

        var TPL_THANKS_MESSAGE = A.Template('<h3>Thanks for contacting us and somebody will respond in {hrsMessage}</h3>' +
            '<div><img src="http://lorempixel.com/780/480/business/" alt="thank you" style="opacity:0.8"/></div>');
        var GPForm = function (portletNamespace, formNode, plid, hrsMessage) {
            var instance = this;
            instance.portletNamespace = portletNamespace;
            instance.formNode = formNode;
            instance.plid = plid;
            instance.hrsMessage = hrsMessage;
        };

        GPForm.prototype = {
            init: function () {
                var instance = this;
                instance.formNode.on('submit', function (e) {
                    e.preventDefault();
                    instance._submitForm();
                });
                console.log('GPForm initialized');
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
                                    var thankYouMessageHTML = TPL_THANKS_MESSAGE.parse(
                                        {
                                            hrsMessage: instance.hrsMessage
                                        }
                                    );
                                    instance.formNode.get('parentNode').html(thankYouMessageHTML);
                                },
                                failure: function () {
                                    console.log('on-error-> ' + this)
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
        requires: ['aui-node', 'aui-io-request', 'liferay-util-window', 'liferay-portlet-url', 'json', 'liferay-form', 'aui-template-deprecated']
    }
);
