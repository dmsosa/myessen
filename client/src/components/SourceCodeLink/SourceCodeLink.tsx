function SourceCodeLink({ classN, left, right }: { classN?: string, left?: boolean, right?: boolean }) {
    
    const position = left ? "left" : right ? "right" : "";
    return (
        <ul className={`nav-link pull-xs-${position} ${classN}`}>
            <li className="nav-item">
                <a 
                className="nav-link"
                href="https://github.com/dmsosa/myessen"
                >
                    <i className="io-social-github"></i> Source code
                </a>
            </li>
        </ul>
    );
}

export default SourceCodeLink;