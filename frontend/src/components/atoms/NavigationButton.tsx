import { Link } from '@mui/material';

interface NavigationButtonProps {
    text: string;
    onClick: React.MouseEventHandler<HTMLAnchorElement> | React.MouseEventHandler<HTMLSpanElement>;
}

export default function NavigationButton({ text, onClick }: NavigationButtonProps) {
    return (
        <div>
            <Link component="button" variant="body2"
                onClick={onClick}>{text}</Link>
        </div>
    )
}
