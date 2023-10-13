import avatar from "../../../public/peach.png";

function Avatar({ alt, className, src } : {alt?: string, className?: string, src?: string}) {
    return (
        <img 
        alt={alt || ""}
        className={className || "user-avatar"}
        src={src || avatar }
        />
    )
}

export default Avatar;