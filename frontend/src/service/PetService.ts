import api from "../config/Api";
import { Pet } from "../types/models/Pet.model";

const PetService = {

    getPetByUserId: (userId: string) => {
        return api.get(`/api/pet/${userId}`);
    },

    updatePet: (pet: Pet) => {
        return api.put("/api/pet", pet);
    },

    createPet: (pet: Pet) => {
        return api.post(`/api/pet`, pet);
    },

    deletePost: (id: string) => {
        return api.delete(`/api/images/${id}`);
    },
};

export default PetService;
