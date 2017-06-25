AUI.add('gp-web-form', function (A) {

        var GPForm = function (portletNamespace, formName) {
            var instance = this;
            instance.portletNamespace = portletNamespace;
            instance.formName = formName;
        };

        GPForm.prototype = {
            submitForm: function () {
                var instance = this;
                var url = document[instance.portletNamespace + instance.formName].action;
                var data = {};
                //TODO add formId to submit

                A.io.request(url,
                    {
                        method: 'POST',
                        data: data,
                        dataType: 'json',
                        on: {
                            success: function () {
                                var data = this.get('responseData');
                                if (data.status === 'SUCCESS') {
                                    // TODO success
                                } else if (data.status === 'ERROR') {
                                    // TODO error
                                }
                            }
                        }
                    }
                );
            }
        };

        Liferay.Portlet.GPForm = GPForm;
    },
    '',
    {
        requires: ['aui-node', 'aui-io-request', 'liferay-util-window', 'liferay-portlet-url', 'json']
    }
);
