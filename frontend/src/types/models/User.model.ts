import { Role } from './Role.model';

/**
 * User type
 */
export type User = {
    id: string;
    username: string;
    roles: Role[];
};