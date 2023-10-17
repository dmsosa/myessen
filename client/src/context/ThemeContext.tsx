import { ReactNode, createContext, useContext, useEffect, useState } from "react";

type Theme = "light" | "dark";
export type ThemeContextType = {
    theme: Theme;
    setTheme: (t: Theme) => void;
}

const ThemeContext = createContext<ThemeContextType | null >(null);

export function useTheme() {
    return useContext(ThemeContext);
}

function ThemeProvider({children}: { children: ReactNode | ReactNode[] }) {
    const [theme, setTheme] = useState<Theme>("light");
    return (
        <ThemeContext.Provider value={{theme, setTheme}}>
            {children}
        </ThemeContext.Provider>
    )
}

export default ThemeProvider;

