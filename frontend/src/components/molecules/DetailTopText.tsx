import { AppBar, Toolbar, Typography } from '@mui/material'

interface TopTextProps {
    drawerWidth: number,
    petName: string,
    userName: string,
}

export default function DetailTopText({ petName, drawerWidth, userName }: TopTextProps) {
    return (
        <AppBar
            position="fixed"
            sx={{
                width: { sm: `calc(100% - ${drawerWidth}px)` },
                ml: { sm: `${drawerWidth}px` },
            }}>
            <Toolbar>
                <Typography variant="h6" noWrap component="div">
                    What's up, {userName}! Say hi to {petName}
                </Typography>
            </Toolbar>
        </AppBar>
    )
}
