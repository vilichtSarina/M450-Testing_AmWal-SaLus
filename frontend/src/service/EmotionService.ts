import { PetState } from "../assets/enums";
import { Pet } from "../types/models/Pet.model";

/**
 * Service to handle everything regarding a pet's emotions.
 * This ranges from determining emotion based on a stat and also providing
 * a simple way of displaying the pet's state, i.e. providing correct images.
 */

const enum SatisfactionLevel {
    kNeedsNotMet,
    kNeedsMet,
    kNeedsExceeded
}

export default function getEmotion(pet: Pet) {

    const getOverallSatisfaction = (pet: Pet): SatisfactionLevel => {
        // Needs are exceeded above and beyond the minimum requirements
        if (pet.stateFood > 10 && pet.stateHappiness > 10
            && pet.stateHygiene > 10 && pet.stateLove > 10) {
            return SatisfactionLevel.kNeedsExceeded;
        }
        // Needs meet minimal satisfaction requirements
        if (pet.stateFood > 5 && pet.stateHappiness > 5
            && pet.stateHygiene > 5 && pet.stateLove > 5) {
            return SatisfactionLevel.kNeedsMet;
        }
        return SatisfactionLevel.kNeedsNotMet;
    }

    const getMostLackingState = (pet: Pet): PetState => {
        const needs = [pet.stateFood, pet.stateHappiness, pet.stateHygiene, pet.stateLove];
        const lowestScore = Math.min(...needs);

        // Order of if statements decide which needs are more important than others, high to low priority
        if (pet.stateFood === lowestScore) {
            return PetState.kAnnoyed;
        } else if (pet.stateHappiness === lowestScore || pet.stateLove === lowestScore) {
            return PetState.kSad;
        }
        return PetState.kAsleep;
    }

    const getPetEmotion = (pet: Pet): PetState => {

        const satisfactionLevel = getOverallSatisfaction(pet);

        if (satisfactionLevel === SatisfactionLevel.kNeedsExceeded) {
            return PetState.kLove
        } else if (satisfactionLevel === SatisfactionLevel.kNeedsMet) {
            return PetState.kNeutral
        }

        // In case of the needs not being met, find out which needs aren't met
        // to display more descriptive emotion.
        return getMostLackingState(pet);

        return PetState.kAnnoyed;
    }
    return getPetEmotion(pet);

}

export function getImage(petState: PetState) {
    const basePath = "/img/pet/penguin/";

    switch (petState) {
        case PetState.kAnnoyed:
            return basePath + "annoyed.png";
        case PetState.kAsleep:
            return basePath + "asleep.png";
        case PetState.kLove:
            return basePath + "love.png";
        case PetState.kNeutral:
            return basePath + "neutral.png";
        case PetState.kSad:
            return basePath + "sad.png";
    }
}

export function petStateToString(petState: PetState) {
    switch (petState) {
        case PetState.kAnnoyed:
            return "annoyed pet";
        case PetState.kAsleep:
            return "asleep pet";
        case PetState.kLove:
            return "love pet";
        case PetState.kNeutral:
            return "neutral pet";
        case PetState.kSad:
            return "sad pet";
    }
}