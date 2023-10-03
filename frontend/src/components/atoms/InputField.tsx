import TextField from '@mui/material/TextField';

interface TextFieldProps {
    label: string;
}

export default function InputField({ label }: TextFieldProps) {
    return (
        <div>
            <TextField id="outlined-basic" label={label} variant="outlined" />
        </div>
    )
}
