import UserForm from "../organisms/UserForm";
import { FormCallType } from "../../assets/enums";


const LoginPage = () => {

    return (
        <div>
            <UserForm callType={FormCallType.kLogin} />
        </div>
    );
};

export default LoginPage;
