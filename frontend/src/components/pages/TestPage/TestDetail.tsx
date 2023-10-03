import { examplePet, exampleUser } from '../../../types/models/Pet.model'
import '../PetPage.tsx';
import PetPage from '../PetPage.tsx';

function TestDetail() {

    return (
        <div>
            <PetPage user={exampleUser} pet={examplePet} />
        </div>
    )
}

export default TestDetail
