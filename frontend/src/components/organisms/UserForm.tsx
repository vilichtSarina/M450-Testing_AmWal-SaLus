import InputField from '../atoms/InputField';
import NavigationButton from '../atoms/NavigationButton';
import { FormCallType } from '../../assets/enums';
import { useNavigate } from 'react-router-dom';
import { Button } from '@mui/material';
import { FormikValues, useFormik } from 'formik';

type UserFormProps = {
    callType: FormCallType;
};

export default function UserForm({ callType }: UserFormProps) {

    const navigate = useNavigate();

    const validateForm = (values: FormikValues) => {
        const errors: { email?: string, password?: string } = {};

        if (!values.email) {
            errors.email = 'Please provide an email';
        }
        if (!values.password) {
            errors.password = 'Please provide a password';
        }

        return errors;
    };

    const formik = useFormik({
        initialValues: {
            email: "",
            password: "",
        },
        validate: validateForm,
        onSubmit: (values) => {
            console.log(values);
        }
    });

    return (
        <div>
            <form onSubmit={formik.handleSubmit}>
                {
                    callType == FormCallType.kLogin && <div>
                        <InputField label='Account Name' />
                        <InputField label='Password' />
                        <Button>Submit</Button>
                        <NavigationButton text='Create an account with an associated pet' onClick={() => navigate("/register")} />
                    </div>
                }
                {
                    callType == FormCallType.kRegister && <div>
                        <InputField label='Account Name' />
                        <InputField label='Password' />
                        <InputField label='Pet Name' />
                        <Button>Submit</Button>
                        <NavigationButton text='Go Back to Login' onClick={() => navigate("/login")} />
                    </div>
                }
            </form>
        </div>
    )
}