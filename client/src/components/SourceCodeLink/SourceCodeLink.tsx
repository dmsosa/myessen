function SourceCodeLink({ left, right }: { left?: boolean, right?: boolean }) {
    
    const position = left ? "left" : right ? "right" : "";
    return (
        <ul className={`nav navbar-nav pull-xs-${position} col`}>
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