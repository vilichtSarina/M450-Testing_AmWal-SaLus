import './App.css'
import Router from './router/Router'
import { createTheme, ThemeProvider } from '@mui/material';

function App() {

  const darkTheme = createTheme({
    palette: {
      mode: 'dark',
    },
  });

  return (
    <ThemeProvider theme={darkTheme}>
      <Router />
    </ThemeProvider>
  )
}

export default App
