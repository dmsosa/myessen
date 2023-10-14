import { createContext, useContext, useEffect, useState } from "react";
import { Theme, ThemeContextType } from "../types/ThemeTypes";
import { TChildren } from "../types/Children";

const ThemeContext = createContext<ThemeContextType | null >(null);

export function useTheme() {
    return useContext(ThemeContext);
}

function ThemeProvider({children}: TChildren) {
    const [theme, setTheme] = useState<Theme>("light");
    return (
        <ThemeContext.Provider value={{theme, setTheme}}>
            {children}
        </ThemeContext.Provider>
    )
}

export default ThemeProvider;

