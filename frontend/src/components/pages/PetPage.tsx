import { Box, CssBaseline } from "@mui/material";
import SideDrawer from "../organisms/SideDrawer.tsx";
import DetailsContainer from "../organisms/DetailsContainer";
import { User } from "../../types/models/User.model";
import { Pet } from "../../types/models/Pet.model";
import DetailTopText from "../molecules/DetailTopText";
import getEmotion, { getImage, petStateToString } from "../../service/EmotionService.ts";
import { useState } from "react";

const drawerWidth = 240;

interface PetPageProp {
    user: User;
    pet: Pet;
}

export default function PetPage({ user, pet }: PetPageProp) {
    // Get the pets emotions based on the backend response
    let petState = getEmotion(pet);
    const [foodState, setFoodState] = useState(pet.stateFood);
    const [happinessState, setHappinessState] = useState(pet.stateHappiness);
    const [hygieneState, setHygieneState] = useState(pet.stateHygiene);
    const [loveState, setLoveState] = useState(pet.stateLove);

    const onFeed = () => {
        if (foodState <= 11.5) {
            setFoodState(foodState + 0.5);
        }
        pet.stateFood = foodState;
        petState = getEmotion(pet)
    }

    const onClean = () => {
        if (foodState <= 11) {
            setHygieneState(hygieneState + 1);
        }
        pet.stateHygiene = hygieneState;
        petState = getEmotion(pet)
    }

    const onPlay = () => {
        if (happinessState <= 11.5) {
            setHappinessState(happinessState + 0.5);
        }
        pet.stateHappiness = happinessState;
        petState = getEmotion(pet)
    }

    const onSnuggle = () => {
        if (happinessState <= 11.5) {
            setHappinessState(happinessState + 0.5);
        }
        if (loveState <= 11) {
            setLoveState(loveState + 1);
        }
        pet.stateHappiness = happinessState;
        pet.stateLove = loveState;
        petState = getEmotion(pet)
    }

    return (
        <Box sx={{ display: 'flex' }}>
            <CssBaseline />
            <DetailTopText drawerWidth={drawerWidth} petName={pet.name} userName={user.username} />
            <SideDrawer
                user={user}
                petName={pet.name}
                drawerWidth={drawerWidth}
                foodState={foodState}
                happinessState={happinessState}
                hygieneState={hygieneState}
                loveState={loveState}
                onFeed={onFeed}
                onClean={onClean}
                onPlay={onPlay}
                onSnuggle={onSnuggle} />
            <DetailsContainer imagePath={getImage(petState)} altText={petStateToString(petState)} />
        </Box>
    )
}
