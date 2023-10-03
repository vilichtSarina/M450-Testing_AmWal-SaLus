import { Box, LinearProgress } from '@mui/material';
import "./StatBar.css"

interface StatBarProp {
    statName: string,
    value: number,
}

export default function StatBar({ statName, value }: StatBarProp) {

    return (
        <div className='component-box'>
            <Box>
                {statName}
                <div className="bar-box">
                    <Box>
                        <LinearProgress variant="determinate" value={100 / 12 * value} />
                    </Box>
                </div>
            </Box>
        </div>
    )
}
