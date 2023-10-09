function Footer() {
    return (
        <div className="footer container-fluid d-flex flex-column h-100 bg-dark text-center">
            <div className="row footer-icon-row">
            <div className="col footer-icon">O</div>
            <div className="col col footer-icon">O</div>
            <div className="col footer-icon">O</div>
            <div className="col footer-icon">O</div>
            <div className="col footer-icon">O</div>
            <div className="col footer-icon">O</div>
            </div>
            <div className="row justify-content-start">
                <p className="abo-label col text-left">Subscribe to our newsletter</p>
            </div>
            <div className="row">
            <form className="abo-form">
            <input className="abo-input input flex-grow-1"  type="text" placeholder="Abonnieren"/>
            <button className="abo-item btn btn-info col col-sm-2">Get</button>
            </form>
            </div>
            
            <div className="footer-p row">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illum nobis consectetur deleniti tempore hic sapiente reprehenderit officia facere dolorem, quas magnam ea asperiores vel, at necessitatibus corporis a quia. Cupiditate?</p>
            </div>
            <div className="footer-row row">
                <ul className="footer-ul col">
                <li className="footer-li"><h1>More</h1></li>
                    <li className="footer-li">Essen</li>
                </ul>
                <ul className="footer-ul col">
                <li className="footer-li"><h1>Support</h1></li>
                    <li>Page</li>
                </ul>
                <ul className="footer-ul col">
                    
                    <li className="footer-li"><h1>Future</h1></li>
                    <li className="footer-li">Coming soon</li>
                </ul>
            </div>
            <div className="footer-row row">
                <div className="col copyright">
                    <h2 className="copyright-text">Copyright</h2>
                </div>
            </div>
        </div>  
    )
}

export default Footer;