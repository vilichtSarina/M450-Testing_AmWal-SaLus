import { Box, Button, Divider, Drawer, List, Toolbar } from '@mui/material'
import { User } from '../../types/models/User.model'
import StatBar from '../molecules/StatBar'
import './SideDrawer.css'

interface DrawerProps {
    user: User,
    drawerWidth: number,
    petName: string,
    foodState: number,
    happinessState: number,
    hygieneState: number,
    loveState: number,
    onFeed: any,
    onClean: any,
    onPlay: any,
    onSnuggle: any
}

function SideDrawer({ drawerWidth,
    petName,
    foodState,
    happinessState,
    hygieneState,
    loveState,
    onFeed,
    onClean,
    onPlay,
    onSnuggle }: DrawerProps) {

    const drawer = (
        <div>
            <Toolbar />
            How {petName} is doing
            <Divider />
            <List>
                <StatBar statName='Food' value={foodState} />
                <StatBar statName='Happiness' value={happinessState} />
                <StatBar statName='Hygiene' value={hygieneState} />
                <StatBar statName='Love' value={loveState} />
            </List>
            <Divider />
            <List>
                Interact with your pet!
                <div className="button-container">
                    <Button className='action-button' onClick={() => onFeed()} variant="outlined">Feed</Button>
                    <Button className='action-button' onClick={() => onClean()} variant="outlined">Clean</Button>
                    <Button className='action-button' onClick={() => onPlay()} variant="outlined">Play</Button>
                    <Button className='action-button' onClick={() => onSnuggle()} variant="outlined">Snuggle</Button>
                </div>
            </List>
        </div>
    )
    return (
        <Box
            component="nav"
            sx={{ width: { sm: drawerWidth }, flexShrink: { sm: 0 } }}>
            <Drawer
                variant="permanent"
                sx={{
                    display: { xs: 'none', sm: 'block' },
                    '& .MuiDrawer-paper': { boxSizing: 'border-box', width: drawerWidth },
                }}
                open
            >
                {drawer}
            </Drawer>
        </Box>
    )
}

export default SideDrawer
