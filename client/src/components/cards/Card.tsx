interface CardProps {
    name:string,
    kcal:number
}

export function Card(props : CardProps) {
    return (
        <div className="card">
            <h1>name:{props.name}</h1>
            <h2>kcal:{props.kcal}</h2>
        </div>
    )
}