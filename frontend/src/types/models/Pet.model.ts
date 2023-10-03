import authorities from "../../config/Authorities";
import roles from "../../config/Roles";
import { Authority } from "./Authority.model";
import { Food } from "./Food.model";
import { Love } from "./Love.model";
import { Role } from "./Role.model";
import { User } from "./User.model";

/**
 * Pet type
 * 
 * Contains stats from 0 to 12 stored in the 'state-' variables.
 * 
 */
export type Pet = {
  id: string;
  name: string;
  owner: User;
  food: Food;
  love: Love;
};

const authority: Authority = {
  id: "default",
  name: authorities.DEFAULT
};

const defaultRole: Role = {
  id: "default",
  name: roles.DEFAULT,
  authorities: [authority]
};


export const exampleUser: User = {
  id: "yo",
  username: "bruh",
  roles: [defaultRole]
};

export const examplePet: Pet = {
  id: "id",
  name: "hans",
  owner: exampleUser,
  food: {
    id: "food",
    lastUpdated: 0,
  },
  love: {
    id: "love",
    lastUpdated: 0,
  }
}