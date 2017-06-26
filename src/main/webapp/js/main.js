AUI.add('gp-web-form', function (A) {

        var GPForm = function (portletNamespace, formNode) {
            var instance = this;
            instance.portletNamespace = portletNamespace;
            instance.formNode = formNode;
        };

        GPForm.prototype = {
            init: function() {
                var instance = this;
                instance.formNode.on('submit', function(e) {
                    instance._submitForm();
                });
            },

            _submitForm: function () {
                var instance = this;
                console.log(instance.portletNamespace + ' submit hit ->');
                /*var url = document[instance.portletNamespace + instance.formName].action;
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
                );*/
            }
        };

        Liferay.Portlet.GPForm = GPForm;
    },
    '',
    {
        requires: ['aui-node', 'aui-io-request', 'liferay-util-window', 'liferay-portlet-url', 'json', 'liferay-form']
    }
);
